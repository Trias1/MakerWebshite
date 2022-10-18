var LOGIN_MODE = {
        'AUTOMATIC': "auto"
    },
    autoLogin = Prefab.loginmode === LOGIN_MODE.AUTOMATIC;
Prefab.isInsideIframe = window.self != window.top;
/*
 * This function will be invoked when any of this prefab's property is changed
 * @key: property name
 * @newVal: new value of the property
 * @oldVal: old value of the property
 */

function propertyChangeHandler(key, newVal, oldVal) {
    /*
               switch (key) {
               case "prop1":
               // do something with newVal for property 'prop1'
               break;
               case "prop2":
               // do something with newVal for property 'prop2'
               break;
               }
               */

}
/* register the property change handler */

Prefab.onPropertyChange = propertyChangeHandler;

function toggleSignInButton(enable) {
    var signInBtn = Prefab.Widgets.signInButton.$element;
    if (!enable) {
        signInBtn.attr('disabled', 'disabled');
    } else {
        signInBtn.removeAttr('disabled');
    }
}

function openWindow(href) {
    if (!href) {
        return;
    }
    window.open(href, Prefab.isInsideIframe ? '_blank' : '_self', "width=600,height=700");
}
Prefab.OAuthHandlerServiceGetLoginURLonSuccess = function(variable, data) {
    Prefab.loginurl = data && data.value ? data.value : '';
    Prefab.onLoginurlfetch(null, {
        'loginurl': Prefab.loginurl
    });
    toggleSignInButton(!Prefab.accesstoken);
    if (autoLogin && !Prefab.accesstoken) {
        openWindow(Prefab.loginurl);
    }
};


function login() {
    Prefab.Widgets.signInButton.$element.click();
}
Prefab.onReady = function() {
    Prefab.login = login;
};

Prefab.signInButtonClick = function($event, widget) {
    openWindow(Prefab.loginurl);
};

Prefab.OAuthHandlerServiceGetAccessTokenonSuccess = function(variable, data) {
    var callbackParams;
    if (data && data.value) {
        Prefab.onAccesstokenfetch(null, {
            'accesstoken': Prefab.accesstoken
        });
        Prefab.Widgets.signInButton.disabled = true;
        toggleSignInButton(false);
        if (Prefab.loginsuccessmessage) {
            Prefab.Actions.loginSuccess.invoke();
        }
    } else {
        if (Prefab.isInsideIframe) {
            callbackParams = JSON.stringify({
                'WMOAuthState': true
            });
        } else {
            callbackParams = "csrf8888";
        }
        Prefab.Variables.OAuthHandlerServiceGetLoginURL.setInput('state', callbackParams);
        Prefab.Variables.OAuthHandlerServiceGetLoginURL.invoke();
    }
};