import { createRouter, createWebHistory } from 'vue-router';
import LoginPage from './components/LoginPage.vue';
import MovieDetails from './components/MovieDetails.vue';
import PaymentPage from './components/PaymentPage.vue';
import HomePage from './components/HomePage.vue';
import AccountInfo from './components/AccountInfo.vue';

const routes = [
  //{ path: '/', redirect: '/login' }, // Redirect root to Login
  { path: '/', component: HomePage, name: 'HomePage' },
  { path: '/login', component: LoginPage, name: 'LoginPage' },
  { path: '/movie/:id', component: MovieDetails, props: true },
  { path: '/account', component: AccountInfo, name: 'AccountInfo' },
  { path: '/payment', component: PaymentPage, name: 'PaymentPage' },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
