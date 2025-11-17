import React, { useState } from 'react';
import {
  View,
  Text,
  TextInput,
  TouchableOpacity,
  StyleSheet,
  KeyboardAvoidingView,
  Platform,
  ActivityIndicator,
} from 'react-native';
import { StatusBar } from 'expo-status-bar';
import authService from '../services/authService';
import { setUserInfo } from '../utils/crashlytics';

export default function LoginScreen({ navigation }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState({ type: '', text: '' });

  const validateEmail = (email) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  };

  const handleLogin = async () => {
    // Clear previous messages
    setMessage({ type: '', text: '' });

    // Validation
    if (!email.trim()) {
      setMessage({ type: 'error', text: 'Please enter your email' });
      return;
    }

    if (!validateEmail(email)) {
      setMessage({ type: 'error', text: 'Please enter a valid email address' });
      return;
    }

    if (!password.trim()) {
      setMessage({ type: 'error', text: 'Please enter your password' });
      return;
    }

    try {
      setLoading(true);
      const response = await authService.login({
        email: email.trim(),
        password: password,
      });

      // Check if email verification is required
      if (response.status === false && response.action === 'email_verification') {
        // Navigate to OTP verification for email verification
        setLoading(false);
        navigation.navigate('OTPValidation', {
          email: email.trim(),
          type: 'email_verification',
        });
        return;
      }

      // Login successful - response contains: message, user, token
      setMessage({ type: 'success', text: response.message || 'Login successful' });

      // Set user info in Crashlytics for error tracking
      if (response.user) {
        await setUserInfo(
          response.user.id || 'unknown',
          response.user.email || email.trim(),
          response.user.name || ''
        );
      }

      // Navigate after a short delay to show the success message
      setTimeout(() => {
        navigation.navigate('Main');
      }, 1500);
    } catch (error) {
      // Check if this is an email verification required error
      if (error.status === 403 && error.message && error.message.toLowerCase().includes('verify your email')) {
        // Navigate to OTP verification for email verification
        setLoading(false);
        navigation.navigate('OTPValidation', {
          email: email.trim(),
          type: 'email_verification',
        });
        return;
      }

      // Handle different error scenarios
      let errorMessage = 'Something went wrong. Please try again.';

      if (error.status === 0) {
        // Network error
        errorMessage = 'Unable to connect to server. Please check your internet connection.';
      } else if (error.message) {
        // Server returned an error message
        errorMessage = error.message;
      }

      setMessage({ type: 'error', text: errorMessage });
    } finally {
      setLoading(false);
    }
  };

  return (
    <KeyboardAvoidingView
      behavior={Platform.OS === 'ios' ? 'padding' : 'height'}
      style={styles.container}
    >
      <StatusBar style="dark" />
      <View style={styles.content}>
        <View style={styles.header}>
          <Text style={styles.title}>Vehicle Tracker</Text>
          <Text style={styles.subtitle}>Sign in to continue</Text>
        </View>

        <View style={styles.form}>
          {message.text ? (
            <View style={[styles.messageContainer, message.type === 'error' ? styles.errorMessage : styles.successMessage]}>
              <Text style={styles.messageText}>{message.text}</Text>
            </View>
          ) : null}

          <View style={styles.inputContainer}>
            <Text style={styles.label}>Email</Text>
            <TextInput
              style={styles.input}
              placeholder="Enter your email"
              value={email}
              onChangeText={setEmail}
              keyboardType="email-address"
              autoCapitalize="none"
              autoCorrect={false}
            />
          </View>

          <View style={styles.inputContainer}>
            <Text style={styles.label}>Password</Text>
            <TextInput
              style={styles.input}
              placeholder="Enter your password"
              value={password}
              onChangeText={setPassword}
              secureTextEntry
              autoCapitalize="none"
            />
          </View>

          <TouchableOpacity
            style={[styles.loginButton, loading && styles.loginButtonDisabled]}
            onPress={handleLogin}
            disabled={loading}
          >
            {loading ? (
              <ActivityIndicator color="#fff" />
            ) : (
              <Text style={styles.loginButtonText}>Login</Text>
            )}
          </TouchableOpacity>

          <TouchableOpacity
            style={styles.forgotPassword}
            onPress={() => navigation.navigate('ForgotPassword')}
          >
            <Text style={styles.forgotPasswordText}>Forgot Password?</Text>
          </TouchableOpacity>

          <View style={styles.signupContainer}>
            <Text style={styles.signupText}>Don't have an account? </Text>
            <TouchableOpacity onPress={() => navigation.navigate('Register')}>
              <Text style={styles.signupLink}>Sign up</Text>
            </TouchableOpacity>
          </View>
        </View>
      </View>
    </KeyboardAvoidingView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f5f5f5',
  },
  content: {
    flex: 1,
    justifyContent: 'center',
    paddingHorizontal: 30,
  },
  header: {
    alignItems: 'center',
    marginBottom: 40,
  },
  title: {
    fontSize: 32,
    fontWeight: 'bold',
    color: '#333',
    marginBottom: 8,
  },
  subtitle: {
    fontSize: 16,
    color: '#666',
  },
  form: {
    width: '100%',
  },
  messageContainer: {
    padding: 12,
    borderRadius: 8,
    marginBottom: 20,
  },
  errorMessage: {
    backgroundColor: '#fee',
    borderWidth: 1,
    borderColor: '#fcc',
  },
  successMessage: {
    backgroundColor: '#efe',
    borderWidth: 1,
    borderColor: '#cfc',
  },
  messageText: {
    fontSize: 14,
    textAlign: 'center',
  },
  inputContainer: {
    marginBottom: 20,
  },
  label: {
    fontSize: 14,
    fontWeight: '600',
    color: '#333',
    marginBottom: 8,
  },
  input: {
    backgroundColor: '#fff',
    borderWidth: 1,
    borderColor: '#ddd',
    borderRadius: 8,
    paddingHorizontal: 16,
    paddingVertical: 12,
    fontSize: 16,
    color: '#333',
  },
  loginButton: {
    backgroundColor: '#007AFF',
    borderRadius: 8,
    paddingVertical: 14,
    alignItems: 'center',
    marginTop: 10,
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 3,
  },
  loginButtonDisabled: {
    opacity: 0.6,
  },
  loginButtonText: {
    color: '#fff',
    fontSize: 16,
    fontWeight: 'bold',
  },
  forgotPassword: {
    alignItems: 'center',
    marginTop: 20,
  },
  forgotPasswordText: {
    color: '#007AFF',
    fontSize: 14,
  },
  signupContainer: {
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 30,
  },
  signupText: {
    color: '#666',
    fontSize: 14,
  },
  signupLink: {
    color: '#007AFF',
    fontSize: 14,
    fontWeight: 'bold',
  },
});
