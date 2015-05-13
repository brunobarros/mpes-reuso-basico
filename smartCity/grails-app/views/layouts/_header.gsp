<div class="header header-bg clearfix">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a href="${createLink(uri: '/')}" id="app-logo">
                <span class="fa fa-connectdevelop sys-logo"></span>
                <span class="sys-name">Smart City Gateway</span>
            </a>
        </div>
        <div class="user-profile">
            <g:if test="${sec.loggedInUserInfo(field: 'id').length()==0}">
                <a href="#" data-toggle="modal" data-target="#md-signin"
                   data-backdrop="static" id="signin" title="Sign in" class="a-icon"><span class="fa fa-sign-in"> Entrar</span></a>
            </g:if>
            <g:if test="${sec.loggedInUserInfo(field: 'id').length()>0}">
                <span style="color:#ffffff" class="fa fa-user">&#09;<span id="userLogged" style="color:#fff">${sec.loggedInUserInfo(field: 'username')}</span></span>
                <a href="${createLink(uri: '/j_spring_security_logout')}" id="logout" title="Log out" class="a-icon"><span class="fa fa-sign-out"></span></a>
            </g:if>
        </div>
    </div>
</div>