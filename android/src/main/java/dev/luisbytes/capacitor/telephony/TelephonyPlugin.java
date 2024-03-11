package dev.luisbytes.capacitor.telephony;

import android.Manifest;
import android.os.Build;
import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;

@CapacitorPlugin(
    name = "Telephony",
    permissions = { @Permission(alias = "phone_state", strings = { Manifest.permission.READ_PHONE_STATE }) }
)
public class TelephonyPlugin extends Plugin {

    private Telephony implementation;

    @Override
    public void load() {
        implementation = new Telephony(getContext());
    }

    @PluginMethod
    public void getInfo(PluginCall call) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2) {
            final PermissionState permissionState = getPermissionState("phone_state");

            if (permissionState != PermissionState.GRANTED) {
                requestPermissionForAlias("phone_state", call, "phoneStatePermsCallback");

                return;
            }
        }

        final JSObject info = implementation.getInfo();

        call.resolve(info);
    }

    @PermissionCallback
    private void phoneStatePermsCallback(PluginCall call) {
        if (getPermissionState("phone_state") == PermissionState.GRANTED) {
            getInfo(call);
        } else {
            call.reject("Permission is required");
        }
    }
}
