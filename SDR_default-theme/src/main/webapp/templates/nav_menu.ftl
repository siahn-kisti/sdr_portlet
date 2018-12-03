<nav class="${nav_css_class}" id="navigation" role="navigation">
	<div id="nav-menu">
		<div id="nav-menu-bar">
		<ul id="nav-manu-area">
			<#list nav_items as nav_item>
				<#assign nav_item_attr_has_popup = "" />
				<#assign nav_item_attr_has_expanded = "" />
				<#assign nav_item_attr_selected = "" />					
				<#assign nav_item_css_class = "" />
				<#assign nav_item_caret = "" />
				<#assign nav_item_link_css_class = "" />
		
				<#if nav_item.isSelected()>
					<#assign nav_item_attr_selected = "aria-selected='true'" />
					<#assign nav_item_css_class = "active" />
				</#if>
				
				<#if nav_item.hasChildren()>
					<#assign nav_item_attr_has_popup = "aria-haspopup='true'" />
					<#assign nav_item_attr_has_expanded = "aria-expanded='false'" />
					<#assign nav_item_caret = "<span class='caret'></span>" />
					<#assign nav_item_css_class = nav_item_css_class + " dropdown" />
					<#assign nav_item_link_css_class = "dropdown-toggle" />
				</#if>
		
				<li class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" ${nav_item_attr_selected} role="presentation">
					<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} ${nav_item_attr_has_expanded} class="${nav_item_link_css_class}" href="${nav_item.getURL()}" ${nav_item.getTarget()} role="button">
						${nav_item.icon()} ${nav_item.getName()} ${nav_item_caret}
					</a>
		
					<#if nav_item.hasChildren()>
						<ul class="dropdown-menu" role="menu">
							<#list nav_item.getChildren() as nav_child>	
								<#if nav_item.isSelected()>
									<!-- <#assign nav_child_attr_selected = "aria-selected='true'" /> -->
								</#if>
		
								<li id="layout_${nav_child.getLayoutId()}" role="presentation">
									<a aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="button">${nav_child.getName()}</a>
								</li>
							</#list>
						</ul>
					</#if>
				</li>
			</#list>
		</ul>
        </div>
	</div>
</nav>
<script>
	Liferay.Data.NAV_LIST_SELECTOR = 'div#nav-menu > div#nav-menu-bar > ul';
</script>