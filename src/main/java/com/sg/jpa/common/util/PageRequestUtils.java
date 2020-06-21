package com.sg.jpa.common.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageRequestUtils {

	public static PageRequest getRequest(int page, int size, Sort sort) {
		return PageRequest.of(page - 1, size, sort);
	}
}
