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
* [`getNetworkType(...)`](#getnetworktype)
* [Interfaces](#interfaces)
* [Enums](#enums)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getInfo()

```typescript
getInfo() => any
```

**Returns:** <code>any</code>

--------------------


### getNetworkType(...)

```typescript
getNetworkType(options?: { withBasicPermission?: boolean | undefined; } | undefined) => any
```

| Param         | Type                                            |
| ------------- | ----------------------------------------------- |
| **`options`** | <code>{ withBasicPermission?: boolean; }</code> |

**Returns:** <code>any</code>

--------------------


### Interfaces


#### TelephonyInfo

| Prop                      | Type                                                                                  |
| ------------------------- | ------------------------------------------------------------------------------------- |
| **`dataState`**           | <code><a href="#telephonydatastate">TelephonyDataState</a></code>                     |
| **`signalStrengthLevel`** | <code><a href="#telephonysignalstrengthlevel">TelephonySignalStrengthLevel</a></code> |
| **`simOperatorName`**     | <code>string</code>                                                                   |


### Enums


#### TelephonyDataState

| Members                    | Value                               |
| -------------------------- | ----------------------------------- |
| **`UNKNOWN`**              | <code>"UNKNOWN"</code>              |
| **`DISCONNECTED`**         | <code>"DISCONNECTED"</code>         |
| **`CONNECTING`**           | <code>"CONNECTING"</code>           |
| **`CONNECTED`**            | <code>"CONNECTED"</code>            |
| **`SUSPENDED`**            | <code>"SUSPENDED"</code>            |
| **`DISCONNECTING`**        | <code>"DISCONNECTING"</code>        |
| **`HANDOVER_IN_PROGRESS`** | <code>"HANDOVER_IN_PROGRESS"</code> |


#### TelephonySignalStrengthLevel

| Members        | Value                   |
| -------------- | ----------------------- |
| **`UNKNOWN`**  | <code>"UNKNOWN"</code>  |
| **`NONE`**     | <code>"NONE"</code>     |
| **`POOR`**     | <code>"POOR"</code>     |
| **`MODERATE`** | <code>"MODERATE"</code> |
| **`GOOD`**     | <code>"GOOD"</code>     |
| **`GREAT`**    | <code>"GREAT"</code>    |


#### TelephonyNetworkType

| Members       | Value                  |
| ------------- | ---------------------- |
| **`UNKNOWN`** | <code>"UNKNOWN"</code> |
| **`TWO_G`**   | <code>"2G"</code>      |
| **`THREE_G`** | <code>"3G"</code>      |
| **`LTE`**     | <code>"LTE"</code>     |
| **`FIVE_G`**  | <code>"5G"</code>      |

</docgen-api>
