import { registerPlugin } from '@capacitor/core';

import type { TelephonyPlugin } from './definitions';

const Telephony = registerPlugin<TelephonyPlugin>('Telephony', {
  web: () => import('./web').then(m => new m.TelephonyWeb()),
});

export * from './definitions';
export { Telephony };
