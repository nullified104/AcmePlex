<template>
<nav class="navbar navbar-expand-lg bg-dark">
  <div class="container-fluid">
    <span style="color: #F0F0F0; font-weight: bold;">ACME</span><span style="color: #00AFFF; font-style: italic;">PLEX</span>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-2 mb-2 mb-lg-0" style="color:beige">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Movies</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Tickets</a>
        </li>
      <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Theatres</a>
      </li>
      <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Account</a>
      </li>
      </ul>
      <form class="d-flex ms-auto" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-light" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
</template>

<script>
</script>

<style>
.navbar-nav .nav-item .nav-link.active {
  color:#F0F0F0;
}
</style>