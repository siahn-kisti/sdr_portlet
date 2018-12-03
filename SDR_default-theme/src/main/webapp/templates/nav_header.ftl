<div id="nav-width">
    <a id="msc-logo" href="${site_default_url}" title="<@liferay.language_format arguments='${site_name}' key='go-to-x' />">${site_name}</a>

    <#if theme_display.isSignedIn()>
    <div id="nav-login">
        <a href="${my_account_url}"><i class="fa fa-id-badge m-r-10" aria-hidden="true"></i> My Account</a>
    </div>
    </#if>
    <div id="nav-lang">
    <#if theme_display.isSignedIn()>
        <a href="${theme_display.getURLSignOut()}" class="btnLogIn"><i class="fa fa-sign-out" aria-hidden="true"></i> Log Out</a>
    <#else>
        <!-- event class btnLogIn -->
        <a href="${theme_display.getURLSignIn()}" class="btnLogIn"><i class="fa fa-sign-in" aria-hidden="true"></i> Log In</a>
    </#if>
    </div>

	<div id="nav-login">
		<a id="joinBtn" style="display: none;" href="#"><i class="fa fa-id-badge m-r-10" aria-hidden="true"></i> Join</a>
	</div>
    
	<script>
		//joinCommunity
		$("#joinBtn").on('click', function(){
			if(!confirm("Would you like to join the community?")) return;
			$.ajax({
				type: "POST",
				url: "${joinCommunityURL}",
				dataType: "json",
				data: "",
				success: function (e) {
					console.log("success", e);
					if(e.error!=undefined) {
						alert(e.error);
					}else if(e.success!=undefined){
						alert(e.success);
						window.location.reload();
					}
				},
				error: function (e) {
					console.log("error", e);
				}
			});
		});

		//hasJoinCommunity
		$.ajax({
			type: "POST",
			url: "${hasJoinCommunityURL}",
			dataType: "json",
			data: "",
			success: function (e) {
				//console.log("success", e);
				if(e.data!=undefined && e.data) {
					$("#joinBtn").hide();
				}else{
					$("#joinBtn").show();
				}
			},
			error: function (e) {
				console.log("error", e);
			}
		});
	</script>
    
</div>