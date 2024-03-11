import { JsonPipe } from '@angular/common';
import { Component, signal } from '@angular/core';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonList, IonItem, IonLabel, IonTextarea } from '@ionic/angular/standalone';
import { Telephony, TelephonyInfo, TelephonyNetworkType } from '@luisbytes/capacitor-telephony';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  standalone: true,
  imports: [IonTextarea, IonButton, IonHeader, IonToolbar, IonTitle, IonContent, JsonPipe],
})
export class HomePage {
  info = signal<TelephonyInfo | null>(null);

  networkType = signal<{ type: TelephonyNetworkType } | null>(null);

  constructor() { }

  async getInfo() {
    const info = await Telephony.getInfo();

    this.info.set(info);
  }

  async getNetworkType() {
    const networkType = await Telephony.getNetworkType({withBasicPermission: false});

    this.networkType.set(networkType);
  }


}
