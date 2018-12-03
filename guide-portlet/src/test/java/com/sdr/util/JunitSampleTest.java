package com.sdr.util;

import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class JunitSampleTest {

	private final JunitSample junitSample = new JunitSample();

	@Test
	public void testGetName() throws Exception {
		// Mocking of Objects
		BeanLocator beanLocator = mock(BeanLocator.class);
		PortalBeanLocatorUtil.setBeanLocator(beanLocator);

		UserLocalService userLocalService = mock(UserLocalService.class);
		User user = mock(User.class);

		when(beanLocator.locate(UserLocalService.class.getName())).thenReturn(userLocalService);
		when(userLocalService.getUser(10198)).thenReturn(user);
		when(user.getUserId()).thenReturn(10198L);
		when(user.getFirstName()).thenReturn("Joe");

		System.out.println(junitSample.getName(user));

		assertEquals("Mr Joe", junitSample.getName(user));
	}

}