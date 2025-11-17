const fs = require('fs');
const path = require('path');

console.log('=================================');
console.log('Post-Build: Moving APK to builds folder');
console.log('=================================');

const buildDir = path.join(__dirname, '..', 'builds');
const projectRoot = path.join(__dirname, '..');

// Create builds directory if it doesn't exist
if (!fs.existsSync(buildDir)) {
  console.log('Creating builds directory...');
  fs.mkdirSync(buildDir, { recursive: true });
  console.log('✓ Builds directory created');
}

// Find APK file in project root
console.log('Searching for APK file in project root...');
const files = fs.readdirSync(projectRoot);
const apkFile = files.find(file => file.endsWith('.apk'));

if (apkFile) {
  const sourcePath = path.join(projectRoot, apkFile);

  // Generate timestamp for the filename
  const now = new Date();
  const timestamp = now.toISOString().replace(/:/g, '-').split('.')[0];

  // Get build info from environment variables if available
  const platform = process.env.EAS_BUILD_PLATFORM || 'android';
  const profile = process.env.EAS_BUILD_PROFILE || 'preview';

  // Create destination filename
  const destFilename = `vehicle-tracker-${profile}-${timestamp}.apk`;
  const destPath = path.join(buildDir, destFilename);

  // Move APK to builds directory
  console.log(`Moving: ${apkFile}`);
  console.log(`To: builds/${destFilename}`);

  try {
    fs.renameSync(sourcePath, destPath);
    console.log('✓ APK successfully moved to builds folder');
    console.log('=================================');
    console.log(`Location: ${destPath}`);
    console.log('=================================');
  } catch (error) {
    console.error('✗ Failed to move APK:', error.message);
    process.exit(1);
  }
} else {
  console.log('✗ No APK file found in project root');
  console.log('This is normal if the build failed or if building for iOS');
  console.log('=================================');
}
