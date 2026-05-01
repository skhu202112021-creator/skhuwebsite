<script setup>
import {reactive} from "vue";
import {join2} from "@/services/accountService";
import {join1} from "@/services/accountService";
import {useRouter} from "vue-router";

// 반응형 상태
const state = reactive({
  form: {
    name: "",
	department: "",
    loginId: "",
    loginPw: "",
  }
});

// 라우터 객체
const router = useRouter();

// 회원가입 데이터 제출
const submit2 = async () => {
  const res = await join2(state.form);

  if (res.status === 200) {
    window.alert("회원가입을 완료했습니다.");
    await router.push("/");
  }
};
const submit1 = async () => {
  const res = await join1(state.form);

  if (res.status === 200) {
    window.alert("회원가입을 완료했습니다.");
    await router.push("/");
  }
};
</script>

<template>
  <div class="join">
    <div class="container">
      <form class="py-5 d-flex flex-column gap-3" @submit.prevent="submit">
        <h1 class="h5 mb-3">회원가입</h1>
		<h3>Welcome!</h3>
		<img src="../img/ui_1.png"/>
		<table style="margin: 0 auto;">
			<tr><td><strong>이름</strong></td> <td><input id="nme" placeholder="이름" v-model="state.form.name"></input></td></tr>
			<tr><td><strong>학과</strong></td> <td><input id="department" placeholder="학과" v-model="state.form.department"></input></td></tr>
			<tr><td><strong>아이디</strong></td> <td><input type="input" input id="loginId" placeholder="아이디" v-model="state.form.loginId"></input></td></tr>
			<tr><td><strong>비밀번호</strong></td> <td><input type="password" input id="loginPw" placeholder="비밀번호" v-model="state.form.loginPw"></input></td></tr>
			<tr><td></td><td><button v-on:click="submit2()">학생 회원가입</button></td></tr>
			<tr><td></td><td><button v-on:click="submit1()">교수 회원가입</button></td></tr>
		</table>
      </form>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.join > .container {
  max-width: 576px;
}
.container{
		@import url('https://fonts.googleapis.com/css2?family=Gowun+Batang:wght@700&display=swap');
		font-family: "Gowun Batang", serif;
		font-weight: 700;
		font-style: normal;
		color: aliceblue;
		background-image:url("../img/space.png");
		width:50%;
		margin: 0 auto;
		box-shadow : 10px 10px black;
	}
</style>