<!-- FORM : CREATE -->
<div class="modal" id="md-signin" tabindex="-1" role="dialog" aria-labelledby="lb-signin" aria-hidden="true">
    <div class="modal-dialog width350">
        <div class="modal-content">

            <!-- Title -->
            <div class="modal-header">
                <button type="button" class="close hidden" data-dismiss="modal" aria-hidden="true"
                        title="Close" id="create-entity-dismiss">&times;</button>
                <h2 class="modal-title" id="lb-signin">Entrar</h2>
            </div>
            <!-- / Title -->

            <!-- Form Content -->
            <form action="${createLink(uri: '/j_spring_security_check')}" method="POST" id="loginForm" name="loginForm" autocomplete="off">
                <!-- Content -->
                <fieldset class="form modal-body">
                    <!-- PAGE MESSAGES -->
                    <div class="alert alert-danger msg-dialog" role="alert" id="pnl-create-errors">
                        <button type="button" class="close" id="create-error-msg-dismiss">
                            <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                        </button>
                        <div class="messages"></div>
                    </div>
                    <!-- / PAGE MESSAGES -->

                    <div class="form-group row fieldcontain required">
                        <g:textField name="j_username" class="form-control width80p" required="" placeholder="login"/>
                    </div>

                    <div class="form-group row fieldcontain required">
                        <g:passwordField name="j_password" class="form-control width80p" required="" placeholder="senha"/>
                    </div>
                </fieldset>
                <!-- / Content -->
                <!-- / Action -->
                <fieldset class="btn-group-sm modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal" id="bt-cancel-create-entity">
                        <span class="fa fa-close"></span> ${message(code: 'smartCity.default.cancel.label')}
                    </button>
                    <input type="submit" id="submit" class="btn btn-primary" value='${message(code: "springSecurity.login.button")}'/>
                    <div class="clearfix"></div>
                </fieldset>
                <!-- / Action -->
            </form>
            <div class="clearfix"></div>
            <!-- / Form Content -->
        </div>
    </div>
</div>
<!-- / FORM : CREATE -->