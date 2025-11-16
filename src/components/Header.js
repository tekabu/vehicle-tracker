import React from 'react';
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
import { useNavigation } from '@react-navigation/native';

const Header = ({ title, navigation, rightElement, showBackButton = false }) => {
  const nav = useNavigation();

  const handleMenuPress = () => {
    // Try to get the parent navigator (drawer) and open it
    if (navigation?.openDrawer) {
      navigation.openDrawer();
    } else if (nav?.getParent?.()?.openDrawer) {
      nav.getParent().openDrawer();
    } else if (nav?.openDrawer) {
      nav.openDrawer();
    }
  };

  const handleBackPress = () => {
    if (navigation?.goBack) {
      navigation.goBack();
    } else if (nav?.goBack) {
      nav.goBack();
    }
  };

  return (
    <View style={styles.header}>
      {showBackButton ? (
        <TouchableOpacity
          style={styles.backButton}
          onPress={handleBackPress}
        >
          <Text style={styles.backButtonText}>←</Text>
        </TouchableOpacity>
      ) : (
        <TouchableOpacity
          style={styles.menuButton}
          onPress={handleMenuPress}
        >
          <View style={styles.menuIcon}>
            <View style={styles.menuLine} />
            <View style={styles.menuLine} />
            <View style={styles.menuLine} />
          </View>
        </TouchableOpacity>
      )}
      <Text style={styles.headerTitle}>{title}</Text>
      {rightElement && <View style={styles.rightElement}>{rightElement}</View>}
    </View>
  );
};

const styles = StyleSheet.create({
  header: {
    backgroundColor: '#fff',
    paddingTop: 50,
    paddingBottom: 15,
    paddingHorizontal: 20,
    flexDirection: 'row',
    alignItems: 'center',
    borderBottomWidth: 1,
    borderBottomColor: '#e0e0e0',
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 3,
    elevation: 3,
  },
  menuButton: {
    padding: 8,
    marginRight: 15,
  },
  menuIcon: {
    width: 24,
    height: 20,
    justifyContent: 'space-between',
  },
  menuLine: {
    height: 3,
    backgroundColor: '#333',
    borderRadius: 2,
  },
  backButton: {
    padding: 8,
    marginRight: 15,
  },
  backButtonText: {
    fontSize: 28,
    color: '#007AFF',
    fontWeight: '400',
  },
  headerTitle: {
    fontSize: 20,
    fontWeight: '600',
    color: '#333',
    flex: 1,
  },
  rightElement: {
    marginLeft: 12,
  },
});

export default Header;
