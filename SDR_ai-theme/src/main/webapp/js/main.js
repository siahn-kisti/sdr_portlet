/*
	This function gets loaded when all the HTML, not including the portlets, is loaded.
*/
AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal',
	function(A) {
		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		var siteBreadcrumbs = A.one('#breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}

		// modal login popup
		var signIn = A.one('li.sign-in a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}
		
		// modal login popup
		var signIn = A.one('a.btnLogIn');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}

		// Dockbar vertical JS, if dockbar is present
		var portletDockbar = A.one('#_145_dockbar');

		if (portletDockbar) {
			var body = A.one('.aui body');
			body.append('<div class="icon-toggle-dockbar vertical-dockbar-close"><i class="icon-cog"></i></div>');
			body.append('<div class="layer-mobile visible-phone vertical-dockbar-close"></div>');

			var toggleDockbar = A.one('.icon-toggle-dockbar');
			var toggleDockbarClose = A.all('.vertical-dockbar-close');
			var toggleDockbarIcon = A.one('.icon-toggle-dockbar .icon-cog');

			if (toggleDockbar) {
				toggleDockbarClose.on(
					'click',
					function() {
						portletDockbar.toggleClass('over');
						toggleDockbar.toggleClass('over');
						toggleDockbarIcon.toggleClass('icon-remove');
						toggleDockbarIcon.toggleClass('icon-cog');
						body.toggleClass('lfr-has-dockbar-vertical');
					}
				);
			}
		};
	}
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
	}
);

/*
This function gets loaded when everything, including the portlets, is on the page.
*/

Liferay.on(
	'allPortletsReady',
	function() {
	}
);