<template>
  <nav class="navbar navbar-expand-lg bg-dark">
    <div class="container-fluid">
      <router-link to="/" class="navbar-brand text-decoration-none">
        <span style="color: #F0F0F0; font-weight: bold;">ACME</span>
        <span style="color: #00AFFF; font-style: italic;">PLEX</span>
      </router-link>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ms-2 mb-2 mb-lg-0" style="color:beige">
          <li class="nav-item">
            <!-- Router link for Movies -->
            <router-link to="/" class="nav-link active" exact>Movies</router-link>
          </li>
          <li class="nav-item">
            <!-- Router link for Account -->
            <router-link to="/account" class="nav-link active">Account</router-link>
          </li>
        </ul>
        <form class="d-flex ms-auto" role="search">
          <input
            class="form-control me-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
          />
          <button class="btn btn-outline-light" type="submit">Search</button>
        </form>
      </div>
    </div>
  </nav>
  </template>
  
  <script>
  export default {
    name: "NavigationBar",
  };
  </script>
  
  <style>
  .navbar-nav .nav-item .nav-link.active {
    color: #f0f0f0;
  }
  </style>
  