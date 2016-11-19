package com.cyu.laclad.web.controller;
import com.cyu.laclad.domain.ClassGroup;
import com.cyu.laclad.domain.Company;
import com.cyu.laclad.enums.Status;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@RequestMapping("/classgroups")
@Controller
@RooWebScaffold(path = "classgroups", formBackingObject = ClassGroup.class)
public class ClassGroupController {

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid ClassGroup classGroup, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, classGroup);
            return "classgroups/create";
        }
        uiModel.asMap().clear();
        classGroup.persist();
        return "redirect:/classgroups/" + encodeUrlPathSegment(classGroup.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new ClassGroup());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (Company.countCompanys() == 0) {
            dependencies.add(new String[] { "company", "companys" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "classgroups/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("classgroup", ClassGroup.findClassGroup(id));
        uiModel.addAttribute("itemId", id);
        return "classgroups/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("classgroups", ClassGroup.findClassGroupEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) ClassGroup.countClassGroups() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("classgroups", ClassGroup.findAllClassGroups(sortFieldName, sortOrder));
        }
        return "classgroups/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid ClassGroup classGroup, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, classGroup);
            return "classgroups/update";
        }
        uiModel.asMap().clear();
        classGroup.merge();
        return "redirect:/classgroups/" + encodeUrlPathSegment(classGroup.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, ClassGroup.findClassGroup(id));
        return "classgroups/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ClassGroup classGroup = ClassGroup.findClassGroup(id);
        classGroup.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/classgroups";
    }

	void populateEditForm(Model uiModel, ClassGroup classGroup) {
        uiModel.addAttribute("classGroup", classGroup);
        uiModel.addAttribute("companys", Company.findAllCompanys(Status.ACTIVE));
        uiModel.addAttribute("statuses", Arrays.asList(Status.values()));
    }

	String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}
