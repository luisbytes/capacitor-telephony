import { WebPlugin } from '@capacitor/core';

import type {
  TelephonyPlugin,
  TelephonyInfo,
  TelephonyNetworkType,
} from './definitions';

export class TelephonyWeb extends WebPlugin implements TelephonyPlugin {
  async getInfo(): Promise<TelephonyInfo> {
    throw this.unimplemented('Not implemented on web.');
  }

  async getNetworkType(): Promise<{ type: TelephonyNetworkType }> {
    throw this.unimplemented('Not implemented on web.');
  }
}
