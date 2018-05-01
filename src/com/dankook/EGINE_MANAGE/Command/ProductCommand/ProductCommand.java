package com.dankook.EGINE_MANAGE.Command.ProductCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProductCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
