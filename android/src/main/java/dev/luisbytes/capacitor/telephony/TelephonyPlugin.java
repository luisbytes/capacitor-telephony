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
        final JSObject info = implementation.getInfo();

        call.resolve(info);
    }

    @PluginMethod
    public void getNetworkType(PluginCall call) {
        Boolean withBasicPermission = call.getBoolean("withBasicPermission");

        final boolean permissionGranted = this.checkPermission(withBasicPermission);

        if (!permissionGranted) {
            requestPermissionForAlias("phone_state", call, "phoneStatePermsCallback");

            return;
        }

        String state = this.implementation.getDataNetworkType(withBasicPermission);

        JSObject ret = new JSObject();

        ret.put("type", state);

        call.resolve(ret);
    }

    @PermissionCallback
    private void phoneStatePermsCallback(PluginCall call) {
        if (getPermissionState("phone_state") == PermissionState.GRANTED) {
            getNetworkType(call);
        } else {
            call.reject("Permission is required");
        }
    }

    private boolean checkPermission(Boolean withBasicPermission) {
        if (!withBasicPermission && Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2) {
            final PermissionState permissionState = getPermissionState("phone_state");

            return permissionState == PermissionState.GRANTED;
        }

        return true;
    }
}
