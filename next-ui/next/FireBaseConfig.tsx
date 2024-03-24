// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getAuth } from "firebase/auth"
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyB3wvY0vviKzr8CJl7DEFPJi242qOFzgzw",
  authDomain: "nextstage-api.firebaseapp.com",
  projectId: "nextstage-api",
  storageBucket: "nextstage-api.appspot.com",
  messagingSenderId: "165540832861",
  appId: "1:165540832861:web:e4fb23c8863290c8a78fb4",
  measurementId: "G-5VDXL9VCZ7"
};

// Initialize Firebase
export const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
const auth = getAuth(app);