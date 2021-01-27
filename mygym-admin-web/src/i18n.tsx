import i18n from 'i18next';
import LanguageDetector from 'i18next-browser-languagedetector';
import { initReactI18next  } from 'react-i18next';

import common_el from "./translations/el/common.json";
import common_en from "./translations/en/common.json";


i18n
  // load translation using http -> see /public/locales
  // learn more: https://github.com/i18next/i18next-http-backend <-- to be done in the future
  //.use(Backend)
  // detect user language
  // learn more: https://github.com/i18next/i18next-browser-languageDetector
  .use(LanguageDetector)
  // pass the i18n instance to the react-i18next components.
  // Alternative use the I18nextProvider: https://react.i18next.com/components/i18nextprovider
  .use(initReactI18next )
  // init i18next
  // for all options read: https://www.i18next.com/overview/configuration-options
  .init({
    fallbackLng: 'en',
    debug: true,

    interpolation: {
      escapeValue: false, // not needed for react as it escapes by default
    },

    resources: {
      en: {
        common:common_en               // 'common' is our custom namespace
      },
      "en-US": {
        common:common_en               // 'common' is our custom namespace
      },
      el: {
        common: common_el
      },
    },
    // special options for react-i18next
    // learn more: https://react.i18next.com/components/i18next-instance
    react: {
      wait: true,
    },

    
  });

export default i18n;
