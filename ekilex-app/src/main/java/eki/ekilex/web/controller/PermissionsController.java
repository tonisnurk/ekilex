package eki.ekilex.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import eki.ekilex.constant.WebConstant;
import eki.ekilex.data.EkiUser;
import eki.ekilex.data.EkiUserPermData;
import eki.ekilex.service.PermissionService;
import eki.ekilex.web.util.UserContext;

@ConditionalOnWebApplication
@Controller
@SessionAttributes(WebConstant.SESSION_BEAN)
public class PermissionsController implements WebConstant {

	private static final Logger logger = LoggerFactory.getLogger(PermissionsController.class);

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private UserContext userContext;

	@GetMapping(PERMISSIONS_URI)
	public String permissions(Model model) {
		EkiUser user = userContext.getUser();
		if (!user.isAdmin()) {
			return "redirect:" + HOME_URI;
		}
		List<EkiUserPermData> ekiUserPermissions = permissionService.getEkiUserPermissions();
		model.addAttribute("ekiUserPermissions", ekiUserPermissions);
		return PERMISSIONS_PAGE;
	}
}
