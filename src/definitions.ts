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
  '2G' = '2G',
  '3G' = '3G',
  LTE = 'LTE',
  '5G' = '5G',
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
