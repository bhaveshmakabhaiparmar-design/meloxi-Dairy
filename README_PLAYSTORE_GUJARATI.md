# MELOXI DAIRY — તમારા પોતાના નામે APK અને Google Play Store રિલીઝ ગાઇડ

આ પેકેજ **૧૦૦% તમારા નામે (MELOXI Dairy Owner)** તૈયાર કરવામાં આવ્યું છે — તેમાં કોઈ Google AI Studio નું નામ કે લિંક રાખવામાં આવી નથી.

- **App Name:** MELOXI DAIRY
- **Publisher / Developer:** MELOXI Dairy Owner
- **Play Store Package ID:** `com.meloxi.dairy.app`
- **Version:** 1.0.0 (Code: 1)
- **Mode:** Standalone Offline (સીધું એપની અંદરથી ચાલે)

---

## ૧) મોબાઈલ અથવા PC થી તરત APK અને Play Store AAB કેવી રીતે બનાવવી? (સૌથી સહેલો રસ્તો)

1. [github.com](https://github.com) પર તમારું ફ્રી એકાઉન્ટ ખોલીને એક **New Repository** બનાવો (દા.ત. `meloxi-dairy-app`).
2. આ ZIP ફાઇલની અંદરની **બધી જ ફાઇલો (`.github` ફોલ્ડર સહિત)** તે GitHub રેપોઝિટરીમાં Upload કરો.
3. GitHub માં **Actions** ટેબ પર જાઓ → **"Build MELOXI DAIRY APK & Play Store AAB"** → **Run workflow** દબાવો.
4. માત્ર ૩ મિનિટમાં નીચે પ્રમાણે ૩ ફાઇલો ડાઉનલોડ માટે તૈયાર થઈ જશે:
   - `app-debug.apk` (કોઈ પણ Android ફોનમાં સીધી ઇન્સ્ટોલ કરવા માટે)
   - `com.meloxi.dairy.app-signed-release.apk` (ગ્રાહકોને મોકલવા માટે સાઇન્ડ APK)
   - `com.meloxi.dairy.app-playstore.aab` (Google Play Store Console પર અપલોડ કરવા માટે)

---

## ૨) Google Play Store માં તમારા પોતાના નામે રિલીઝ કેવી રીતે કરવું?

1. Google Play Store પર એપ કોના નામે દેખાશે તે **તમારા Google Play Console Developer Account** ના નામ પરથી નક્કી થાય છે (Google AI Studio ના નામે નહીં!).
2. [play.google.com/console](https://play.google.com/console) પર તમારા Email થી Developer Account બનાવો (જ્યાં Developer Name માં તમારું નામ કે ડેરીનું નામ લખશો — તે જ Play Store પર બધાને દેખાશે).
3. Play Console માં **Create App** → App Name માં **MELOXI DAIRY** લખો → Production Release માં **`com.meloxi.dairy.app-playstore.aab`** અપલોડ કરો.
4. જો તમારી પાસે Android Studio હોય તો PC માં પણ આ કમાન્ડ ચલાવીને સીધી APK/AAB બનાવી શકો છો:
   ```bash
   npm install
   npx cap add android
   npx cap sync android
   cd android && ./gradlew assembleDebug bundleRelease
   ```
