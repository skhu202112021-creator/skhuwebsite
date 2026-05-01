<script setup>
/* eslint-disable */
import { ref, onMounted } from 'vue'
const disabled = ref(false)
const show = ref(false)
const showHeader = ref(true)
const showSugang = ref(false)
function warnDisabled() {
  disabled.value = true
  setTimeout(() => {
    disabled.value = false
  }, 1500)
}
import { useRoute } from 'vue-router'
import { watch } from 'vue'

const route = useRoute()

// 경로가 바뀔 때마다 실행되는 감시자
watch(() => route.path, (newPath) => {
  if (newPath === '/') {
    // 1. 메인으로 돌아오면 모든 상태 초기화
    show.value = false;
    showHeader.value = true;
    showSugang.value = false;
    disabled.value = false;
  } else if (newPath === '/sugang') {
    // 2. 수강신청 페이지일 때의 상태
    showHeader.value = false;
    showSugang.value = true;
  } else {
    // 3. 로그인, 회원가입 등 일반 페이지일 때
    show.value = true;
    showHeader.value = true;
    showSugang.value = false;
  }
});
</script>

<template class="parent">
<header v-if="showHeader">
<div class="all">
<div class="header" :class="{ shake: disabled }">
  <button @click="warnDisabled"><img src="@/img/logo_w.png"></button>
  <div>
  <table>
  <tbody>
  <tr><td>
  <router-link to="/login" @click="show = !show">
  		<img src="@/img/new_1_2.png">
  		<div class="menu">로그인</div>
  </router-link>
  </td>
  <td>
  <router-link to="/join" style="display: inline;" @click="show = !show">
    		<img src="@/img/new_1_2.png">
    		<div class="menu">회원가입</div>
  </router-link>
  </td>
  <td>
    <router-link to="/sugang" @click="showHeader = !showHeader; showSugang = !showSugang">
      		<img src="@/img/new_1_4.png">
      		<div class="menu">수강신청</div>
    </router-link>
  </td>
  </tr>
  </tbody>
  </table>
  </div>
</div>
<Transition name="c"><div v-show="show"><router-view style="display: block; text-align: center;"/></div></Transition>
</div>
</header>
<Transition name="s"><div v-if="showSugang"><router-view style="display: block; text-align: center;"/></div></Transition>
</template>

<style scoped>
td{
	width:25%;
}
table{
	margin-top:50px;
	margin-left:auto;
	margin-right:auto;
}
.menu{
	font-size: 20px;
	@import url('https://fonts.googleapis.com/css2?family=Gowun+Batang:wght@700&display=swap');
	font-family: "Gowun Batang", serif;
	font-weight: 700;
	font-style: normal;
	color: black;
}
.all{
	background-size: cover;
	background-image: url("@/img/background.jpg");
	height: 100vh;
}
div{
  display: block;
  text-align: center;
  margin: 0 auto;
}
.header {
  background-color: white;
  height: 200px;
  border-bottom-left-radius: 100px;
  border-bottom-right-radius: 100px;
}
.shake {
  animation: shake 0.82s cubic-bezier(0.36, 0.07, 0.19, 0.97) both;
  transform: translate3d(0, 0, 0);
}

@keyframes shake {
  10%,
  90% {
    transform: translate3d(-1px, 0, 0);
  }

  20%,
  80% {
    transform: translate3d(2px, 0, 0);
  }

  30%,
  50%,
  70% {
    transform: translate3d(-4px, 0, 0);
  }

  40%,
  60% {
    transform: translate3d(4px, 0, 0);
  }
}

.c-enter-active {
  transition: all 0.3s ease-out;
}

.c-leave-active {
  transition: all 0.8s cubic-bezier(1, 0.5, 0.8, 1);
}

.c-enter-from,
.c-leave-to {
  transform: translateX(20px);
  opacity: 0;
}
</style>