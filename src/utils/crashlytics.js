// Try to import Firebase Crashlytics, but handle if it's not available
let crashlytics = null;
let isFirebaseAvailable = false;

try {
  crashlytics = require('@react-native-firebase/crashlytics').default;
  isFirebaseAvailable = true;
} catch (error) {
  console.log('[Crashlytics] Firebase not available - running in Expo Go or without native modules');
  isFirebaseAvailable = false;
}

/**
 * Check if Firebase Crashlytics is available
 */
export const isAvailable = () => isFirebaseAvailable;

/**
 * Initialize Firebase Crashlytics
 * Call this once when the app starts
 */
export const initCrashlytics = async () => {
  if (!isFirebaseAvailable) {
    console.log('[Crashlytics] Skipped - Firebase not available (running in Expo Go)');
    return;
  }

  try {
    // Enable crash collection
    await crashlytics().setCrashlyticsCollectionEnabled(true);
    console.log('[Crashlytics] Initialized successfully');
  } catch (error) {
    console.error('[Crashlytics] Initialization failed:', error);
  }
};

/**
 * Set user information for crash reports
 * @param {string} userId - User ID
 * @param {string} email - User email
 * @param {string} name - User name (optional)
 */
export const setUserInfo = async (userId, email, name = '') => {
  if (!isFirebaseAvailable) return;

  try {
    await crashlytics().setUserId(userId.toString());
    await crashlytics().setAttributes({
      email: email || 'unknown',
      name: name || 'unknown',
    });
    console.log('[Crashlytics] User info set:', userId);
  } catch (error) {
    console.error('[Crashlytics] Failed to set user info:', error);
  }
};

/**
 * Clear user information (call on logout)
 */
export const clearUserInfo = async () => {
  if (!isFirebaseAvailable) return;

  try {
    await crashlytics().setUserId('');
    await crashlytics().setAttributes({
      email: '',
      name: '',
    });
    console.log('[Crashlytics] User info cleared');
  } catch (error) {
    console.error('[Crashlytics] Failed to clear user info:', error);
  }
};

/**
 * Log a non-fatal error to Crashlytics
 * @param {Error} error - The error object
 * @param {string} context - Additional context about where the error occurred
 */
export const logError = (error, context = '') => {
  if (!isFirebaseAvailable) {
    // Fallback to console logging when Firebase is not available
    console.error('[Error]', context, error);
    return;
  }

  try {
    if (context) {
      crashlytics().log(`Context: ${context}`);
    }

    if (error instanceof Error) {
      crashlytics().recordError(error);
    } else {
      // If it's not an Error object, create one
      crashlytics().recordError(new Error(JSON.stringify(error)));
    }

    console.log('[Crashlytics] Error logged:', context, error);
  } catch (err) {
    console.error('[Crashlytics] Failed to log error:', err);
  }
};

/**
 * Log a custom message to Crashlytics
 * @param {string} message - The message to log
 */
export const logMessage = (message) => {
  if (!isFirebaseAvailable) {
    // Fallback to console logging when Firebase is not available
    console.log('[Message]', message);
    return;
  }

  try {
    crashlytics().log(message);
  } catch (error) {
    console.error('[Crashlytics] Failed to log message:', error);
  }
};

/**
 * Set custom key-value pairs for crash reports
 * @param {string} key - The key
 * @param {string|number|boolean} value - The value
 */
export const setAttribute = async (key, value) => {
  if (!isFirebaseAvailable) return;

  try {
    await crashlytics().setAttribute(key, value.toString());
  } catch (error) {
    console.error('[Crashlytics] Failed to set attribute:', error);
  }
};

/**
 * Force a crash for testing purposes
 * ONLY USE IN DEVELOPMENT/TESTING
 */
export const testCrash = () => {
  if (!isFirebaseAvailable) {
    console.warn('[Crashlytics] Test crash unavailable - Firebase not loaded. Build the app to test Crashlytics.');
    alert('Crashlytics is not available in Expo Go. Build the app with EAS to test crash reporting.');
    return;
  }

  crashlytics().crash();
};

/**
 * Check if Crashlytics is enabled
 */
export const isCrashlyticsEnabled = async () => {
  if (!isFirebaseAvailable) return false;

  try {
    return await crashlytics().isCrashlyticsCollectionEnabled();
  } catch (error) {
    console.error('[Crashlytics] Failed to check status:', error);
    return false;
  }
};

export default {
  initCrashlytics,
  setUserInfo,
  clearUserInfo,
  logError,
  logMessage,
  setAttribute,
  testCrash,
  isCrashlyticsEnabled,
  isAvailable,
};
