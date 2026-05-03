<script setup>
	import {reactive} from "vue";
	import {login2} from "@/services/accountService";
	import {login1} from "@/services/accountService";
	
	const state = reactive({
		form: {
			loginId: "",
			loginPw: "",
		}
	});
	const submit2 = async () => {
	  const res = await login2(state.form);
	  switch (res.status) {
	    case 200:
	      window.alert("로그인 성공!");
	      break;

	    case 404:
	      window.alert("입력하신 정보와 일치하는 회원이 없습니다.");
	      break;
	  }
	};
	const submit1 = async () => {
	    const res = await login1(state.form);
		switch (res.status) {
		  case 200:
		    window.alert("로그인 성공!");
		    break;

		  case 404:
		    window.alert("입력하신 정보와 일치하는 회원이 없습니다.");
		    break;
		}
	};
</script>
<template>
	<div class="background">
	<h3>Welcome!</h3>
	<img src="../img/ui_1.png"/>
	<form>
	<table style="margin: 0 auto;">
		<tbody>
		<tr><td><strong>아이디</strong></td> <td><input id="loginId" placeholder="학번" v-model="state.form.loginId"></input></td></tr>
		<tr><td><strong>비밀번호</strong></td> <td><input type="password" id="loginPw" placeholder="비밀번호" v-model="state.form.loginPw"></input></td></tr>
		<tr><td></td><td><button type="button" v-on:click="submit2">학생 로그인</button></td></tr>
		<tr><td></td><td><button type="button" v-on:click="submit1">교수 로그인</button></td></tr>
		</tbody>
	</table>
	</form>
	</div>
</template>
<style>
	.background{
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