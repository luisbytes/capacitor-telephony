package dev.luisbytes.capacitor.telephony;

import static android.telephony.TelephonyManager.DATA_CONNECTED;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.getcapacitor.JSObject;

public class Telephony {

    private final Context context;
    private final TelephonyManager telephonyManager;

    public Telephony(Context context) {
        this.context = context;

        this.telephonyManager = (TelephonyManager) this.context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    public JSObject getInfo() {
        JSObject ret = new JSObject();

        ret.put("signalStrengthLevel", this.getSignalStrengthLevel());
        ret.put("simOperatorName", this.telephonyManager.getSimOperatorName());
        ret.put("dataState", this.getDataState());

        return ret;
    }

    public String getDataNetworkType(@Nullable Boolean withBasicPermission) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N) return "UNKNOWN";

        final boolean permissionGranted = this.checkPermission();

        if (!permissionGranted) return "UNKNOWN";

        if (Boolean.TRUE.equals(withBasicPermission) && Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2) {
            return "UNKNOWN";
        }

        @SuppressLint("MissingPermission")
        final int dataNetworkType = this.telephonyManager.getDataNetworkType();

        if (
            dataNetworkType == TelephonyManager.NETWORK_TYPE_GPRS ||
            dataNetworkType == TelephonyManager.NETWORK_TYPE_EDGE ||
            dataNetworkType == TelephonyManager.NETWORK_TYPE_CDMA ||
            dataNetworkType == TelephonyManager.NETWORK_TYPE_1xRTT ||
            dataNetworkType == TelephonyManager.NETWORK_TYPE_IDEN
        ) {
            return "2G";
        } else if (
            dataNetworkType == TelephonyManager.NETWORK_TYPE_UMTS ||
            dataNetworkType == TelephonyManager.NETWORK_TYPE_EVDO_0 ||
            dataNetworkType == TelephonyManager.NETWORK_TYPE_EVDO_A ||
            dataNetworkType == TelephonyManager.NETWORK_TYPE_HSDPA ||
            dataNetworkType == TelephonyManager.NETWORK_TYPE_HSUPA ||
            dataNetworkType == TelephonyManager.NETWORK_TYPE_HSPA ||
            dataNetworkType == TelephonyManager.NETWORK_TYPE_EVDO_B ||
            dataNetworkType == TelephonyManager.NETWORK_TYPE_EHRPD ||
            dataNetworkType == TelephonyManager.NETWORK_TYPE_HSPAP
        ) {
            return "3G";
        } else if (dataNetworkType == TelephonyManager.NETWORK_TYPE_LTE) {
            return "LTE";
        } else if (dataNetworkType == TelephonyManager.NETWORK_TYPE_NR) {
            return "5G";
        }

        return "UNKNOWN";
    }

    private String getSignalStrengthLevel() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) return "UNKNOWN";

        SignalStrength signalStrength = this.telephonyManager.getSignalStrength();

        if (signalStrength == null) return "UNKNOWN";

        int level = signalStrength.getLevel();

        if (level == 0) return "NONE";
        if (level == 1) return "POOR";
        if (level == 2) return "MODERATE";
        if (level == 3) return "GOOD";
        if (level == 4) return "GREAT";

        return "UNKNOWN";
    }

    private String getDataState() {
        int dataState = this.telephonyManager.getDataState();

        if (dataState == DATA_CONNECTED) return "CONNECTED";

        return "DISCONNECTED";
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private Boolean checkPermission() {
        int permissionState;

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2) {
            permissionState = this.context.checkSelfPermission(Manifest.permission.READ_PHONE_STATE);

            return permissionState == PackageManager.PERMISSION_GRANTED;
        }

        permissionState = this.context.checkSelfPermission(Manifest.permission.READ_BASIC_PHONE_STATE);

        return permissionState == PackageManager.PERMISSION_GRANTED;
    }
    /*
        @SuppressLint("MissingPermission")
        private Integer getCellId() {
            for (CellInfo cellInfo : this.telephonyManager.getAllCellInfo()) {
                if (cellInfo instanceof CellInfoGsm) {
                    return ((CellInfoGsm) cellInfo).getCellIdentity().getCid();
                } else if (cellInfo instanceof CellInfoLte) {
                    return ((CellInfoLte) cellInfo).getCellIdentity().getCi();
                } else if (cellInfo instanceof CellInfoWcdma) {
                    return ((CellInfoWcdma) cellInfo).getCellIdentity().getCid();
                }
            }

            return -1;
        }
    */
}
