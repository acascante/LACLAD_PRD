package com.cyu.laclad.web.controller;
import com.cyu.laclad.domain.Idiom;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/idioms")
@Controller
@RooWebScaffold(path = "idioms", formBackingObject = Idiom.class)
public class IdiomController {
}
