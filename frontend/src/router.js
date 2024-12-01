import { createRouter, createWebHistory } from 'vue-router';
import LoginPage from './components/LoginPage.vue';
import MovieDetails from './components/MovieDetails.vue';
import PaymentPage from './components/PaymentPage.vue';
import HomePage from './components/HomePage.vue';
import AccountInfo from './components/AccountInfo.vue';

const routes = [
  { path: '/', component: HomePage, name: 'HomePage' },
  { path: '/login', component: LoginPage, name: 'LoginPage' },
  { path: '/movie/:id', component: MovieDetails, props: true },
  { 
    path: '/account', 
    component: AccountInfo, 
    name: 'AccountInfo',
    meta: { requiresAuth: true },  // This route needs authentication
  },
  { path: '/payment', component: PaymentPage, name: 'PaymentPage' },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, from, next) => {
  const user = JSON.parse(localStorage.getItem('user'));

  // Check if the route requires authentication
  if (to.meta.requiresAuth) {
    // If the user is not logged in or is a guest, redirect to the login page
    if (!user || user.guest === true) {
      next({ name: 'LoginPage' });  // Redirect to LoginPage if not authenticated or is a guest
    } else {
      next();  // Proceed to Account route if the user is logged in
    }
  } else {
    next();  // Proceed to other routes if no authentication is required
  }
});

export default router;
