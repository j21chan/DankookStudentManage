package com.dankook.EGINE_MANAGE.Command.BorrowCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BorrowCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
