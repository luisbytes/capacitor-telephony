import { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'dev.luisbytes.capacitor.telephony.example',
  appName: 'Telephony Example',
  webDir: 'www',
  server: {
    androidScheme: 'https'
  }
};

export default config;
