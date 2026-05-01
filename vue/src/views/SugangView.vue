<script setup>
// <script setup> 기준
import { onBeforeRouteLeave, useRouter } from 'vue-router'

const router = useRouter()

onBeforeRouteLeave((to, from, next) => {
  if (to.path !== '/') {
    next('/')
  } else {
    next()
  }
})
</script>
<template>
	<body class="sugang">
		<div class="background">
		<h1>수강신청시스템</h1>
		</div>
	</body>
</template>
<style>
.sugang{
		@import url('https://fonts.googleapis.com/css2?family=Gowun+Batang:wght@700&display=swap');
		font-family: "Gowun Batang", serif;
		font-weight: 700;
		font-style: normal;
		background-image: url("@/img/skhu.jpg");
		background-size: cover;
		background-position: center;
		background-repeat: no-repeat;
		background-attachment: fixed;
		height: 100vh;
		width: 100%;
		margin: 0 auto;
		color: black;
}
.background{
		@import url('https://fonts.googleapis.com/css2?family=Gowun+Batang:wght@700&display=swap');
		font-family: "Gowun Batang", serif;
		font-weight: 700;
		font-style: normal;
		color: aliceblue;
		background-image:url("../img/space.png");
		width:50%;
		margin: 0 auto;
}
</style>