package com.udemy.backendninja.controller;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ModelContactDTO;
import com.udemy.backendninja.service.IServiceContact;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ALE
 */
@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("serviceImplContact")
    public IServiceContact iServiceContact;

    @GetMapping("/cancel")
    public String cancel() {
        LOG.info("METHOD: cancel()");
        return "redirect:/contacts/showcontact";
    }

    @GetMapping("/contactForm")
    public String redirectContactoForm(@RequestParam(name = "id", required = false) int id, Model model) {
        LOG.info("METHOD: redirectContactForm()");
        ModelContactDTO modelContactDTO = new ModelContactDTO();
        if (id != 0) {
            modelContactDTO = iServiceContact.findByIdContact(id);
        }
        model.addAttribute("modelContactDTO", modelContactDTO);
        return ViewConstant.CONTACT_FORM;
    }

    @GetMapping("showcontact")
    public ModelAndView showContact(Model model) {
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
        mav.addObject("contacts", iServiceContact.list());
        return mav;
    }

    @PostMapping("/addcontact")
    public ModelAndView addContact(@ModelAttribute(name = "modelContactDTO") ModelContactDTO modelContactDTO, Model model) {
        LOG.info("METHOD: addContact() --- PARAMS: " + modelContactDTO.toString());

        if (null != iServiceContact.registrar(modelContactDTO)) {
            model.addAttribute("result", 1);
        } else {
            model.addAttribute("result", 0);
        }

        return showContact(model);

    }

    @GetMapping("/removeContact")
    public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id, Model model) {
        iServiceContact.removeContact(id);
        model.addAttribute("result", 2);
        return showContact(model);
    }

}
