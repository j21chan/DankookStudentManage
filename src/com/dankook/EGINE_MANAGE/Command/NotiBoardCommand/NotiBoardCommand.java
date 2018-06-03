package com.dankook.EGINE_MANAGE.Command.NotiBoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NotiBoardCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
