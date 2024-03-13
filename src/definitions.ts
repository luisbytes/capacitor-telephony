import type { PermissionState } from "@capacitor/core";

export interface PermissionStatus {
  phone_state: PermissionState;
}

export interface TelephonyPlugin {
  getInfo(): Promise<TelephonyInfo>;

  getNetworkType(options?: {
    withBasicPermission?: boolean;
  }): Promise<{ type: TelephonyNetworkType }>;
}


export enum TelephonySignalStrengthLevel {
  UNKNOWN = "UNKNOWN",
  NONE = "NONE",
  POOR = "POOR",
  MODERATE = "MODERATE",
  GOOD = "GOOD",
  GREAT = "GREAT",
}

export enum TelephonyNetworkType {
  UNKNOWN = "UNKNOWN",
  TWO_G = "2G",
  THREE_G = "3G",
  LTE = "LTE",
  FIVE_G = "5G"
}

export enum TelephonyDataState {
  UNKNOWN = "UNKNOWN",
  DISCONNECTED = "DISCONNECTED",
  CONNECTING = "CONNECTING",
  CONNECTED = "CONNECTED",
  SUSPENDED = "SUSPENDED",
  DISCONNECTING = "DISCONNECTING",
  HANDOVER_IN_PROGRESS = "HANDOVER_IN_PROGRESS"
}

export interface TelephonyInfo {
  dataState: TelephonyDataState;
  signalStrengthLevel: TelephonySignalStrengthLevel;
  simOperatorName: string;
}

