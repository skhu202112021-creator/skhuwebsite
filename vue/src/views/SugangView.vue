<script setup>
import {ref,reactive} from "vue";
import { onBeforeRouteLeave} from 'vue-router'
import {list} from "@/services/subjectService";
const resultSubject = ref('');
const state = reactive({
		form: {
			loginId: "",
			loginPw: "",
		}
	});
const submit2 = async () => {
	  const res = await list(state.form);
	  resultSubject.value = res.data;
	  switch (res.status) {
	    case 200:
	      window.alert("로그인 성공!");
	      break;

	    case 404:
	      window.alert("입력하신 정보와 일치하는 회원이 없습니다.");
	      break;
	  }
	};
onBeforeRouteLeave((to, from, next) => {
  if (to.path !== '/') {
    next('/')
  } else {
    next()
  }
})
const list1 = list()
</script>
<template>
	{{id}}
	<body class="sugang">
		<div class="background">
		<h1>수강신청시스템</h1>
		<!-- 입력 폼 -->
		      <div class="login-form">
		        <input placeholder="아이디를 입력하세요" v-model="state.form.loginId" />
		        <input type="password" placeholder="비밀번호를 입력하세요" v-model="state.form.loginPw" />
		        <button type="button" v-on:click="submit2">조회하기</button>
		      </div>

		      <!-- 결과 출력 -->
		      <div v-if="resultSubject" class="result">
		        조회된 과목: {{ resultSubject }}
		      </div>
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