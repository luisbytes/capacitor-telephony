# @luisbytes/capacitor-telephony

TelephonyManager only for Android

## Install

```bash
npm install @luisbytes/capacitor-telephony
npx cap sync
```

## Android setup

To use this plugin you need to add the following permissions to the `AndroidManifest.xml` before or after the `application` tag.

```xml
<uses-permission android:name="android.permission.READ_BASIC_PHONE_STATE" />
<uses-permission android:name="android.permission.READ_PHONE_STATE" android:maxSdkVersion="32" />
```

## API

<docgen-index>

* [`getInfo()`](#getinfo)
* [Interfaces](#interfaces)
* [Enums](#enums)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getInfo()

```typescript
getInfo() => Promise<TelephonyInfo>
```

**Returns:** <code>Promise&lt;<a href="#telephonyinfo">TelephonyInfo</a>&gt;</code>

--------------------


### Interfaces


#### TelephonyInfo

| Prop                      | Type                                                                                  |
| ------------------------- | ------------------------------------------------------------------------------------- |
| **`dataState`**           | <code><a href="#telephonydatastate">TelephonyDataState</a></code>                     |
| **`networkType`**         | <code><a href="#telephonynetworktype">TelephonyNetworkType</a></code>                 |
| **`signalStrengthLevel`** | <code><a href="#telephonysignalstrengthlevel">TelephonySignalStrengthLevel</a></code> |
| **`simOperationName`**    | <code>string</code>                                                                   |


### Enums


#### TelephonyDataState

| Members            | Value                       |
| ------------------ | --------------------------- |
| **`CONNECTED`**    | <code>'CONNECTED'</code>    |
| **`DISCONNECTED`** | <code>'DISCONNECTED'</code> |


#### TelephonyNetworkType

| Members       | Value                  |
| ------------- | ---------------------- |
| **`'2G'`**    | <code>'2G'</code>      |
| **`'3G'`**    | <code>'3G'</code>      |
| **`LTE`**     | <code>'LTE'</code>     |
| **`'5G'`**    | <code>'5G'</code>      |
| **`UNKNOWN`** | <code>'UNKNOWN'</code> |


#### TelephonySignalStrengthLevel

| Members        | Value                   |
| -------------- | ----------------------- |
| **`UNKNOWN`**  | <code>'UNKNOWN'</code>  |
| **`NONE`**     | <code>'NONE'</code>     |
| **`POOR`**     | <code>'POOR'</code>     |
| **`MODERATE`** | <code>'MODERATE'</code> |
| **`GOOD`**     | <code>'GOOD'</code>     |
| **`GREAT`**    | <code>'GREAT'</code>    |

</docgen-api>
