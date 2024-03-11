import type { PermissionState } from '@capacitor/core';

export interface PermissionStatus {
  phone_state: PermissionState;
}

export enum TelephonySignalStrengthLevel {
  UNKNOWN = 'UNKNOWN',
  NONE = 'NONE',
  POOR = 'POOR',
  MODERATE = 'MODERATE',
  GOOD = 'GOOD',
  GREAT = 'GREAT',
}

export enum TelephonyNetworkType {
  TWO_G = '2G',
  THREE_G = '3G',
  LTE = 'LTE',
  FIVE_G = '5G',
  UNKNOWN = 'UNKNOWN',
}

export enum TelephonyDataState {
  CONNECTED = 'CONNECTED',
  DISCONNECTED = 'DISCONNECTED',
}

export interface TelephonyInfo {
  dataState: TelephonyDataState;
  networkType: TelephonyNetworkType;
  signalStrengthLevel: TelephonySignalStrengthLevel;
  simOperationName: string;
}

export interface TelephonyPlugin {
  getInfo(): Promise<TelephonyInfo>;
}
