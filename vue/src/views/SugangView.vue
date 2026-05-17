<script setup>
import { ref, reactive } from "vue";
import { onBeforeRouteLeave } from 'vue-router'
import { list, listCheck, list2, listCheck2, save } from "@/services/subjectService";
const s = ref(true)
const p = ref(false)
const results = ref("");
const state = reactive({
	form: {
		loginId: "",
		loginPw: "",
	}
});
const stateSubject = reactive({
	form: {
		name: "",
		capacity: "",
	}
});
const submit3 = async () => {
  const res = await save(stateSubject.form);

  if (res.status === 200) {
      window.alert("과목등록을 완료했습니다. 조회버튼을 다시 눌러주세요.");
  }
  
  if (res.status === 400) {
      window.alert("과목명과 정원을 입력해주세요!");
  }
};
const submit = async () => {
	const resCheck = await listCheck(state.form);
	const res = await list(state.form);
	results.value = res.data;
	switch (resCheck.status) {
		case 200:
			window.alert("로그인 성공!");
			break;
		case 404:
			window.alert("입력하신 정보와 일치하는 회원이 없습니다.");
			break;
	}
};
const submit2 = async () => {
	const resCheck = await listCheck2(state.form);
	const res = await list2(state.form);
	results.value = res.data;
	switch (resCheck.status) {
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

	<body class="sugang">
		<div class="background">
			<h1>수강신청시스템</h1>
			<!-- 입력 폼 -->
			<div class="login-form">
				<input type="radio" name="member" @click="s = true; p = false" />학생
				<input type="radio" name="member" @click="p = true; s = false" />교수
				<input placeholder="아이디를 입력하세요" v-model="state.form.loginId" />
				<input type="password" placeholder="비밀번호를 입력하세요" v-model="state.form.loginPw" />
				<button type="button" v-on:click="submit" v-if="s == true && p == false">조회하기</button>
				<button type="button" v-on:click="submit2" v-if="p == true && s == false">조회하기</button>
				<div v-if="p == true && s == false">
					<h1>새로운 과목을 추가하세요!</h1>
					과목명: <input type="text" v-model="stateSubject.form.name"></input>
					정원: <input type="text" v-model="stateSubject.form.capacity"></input>
					<button type="button" v-on:click="submit3">등록하기</button>
				</div>
			</div>
			<table border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>과목명</th>
						<th>학과</th>
						<th>담당 교수</th>
						<th>정원</th>
					</tr>
				</thead>
				<tbody>
					<!-- v-for를 사용하여 배열(users)을 반복, :key는 고유값 권장 -->
					<tr v-for="result in results">
						<td>{{ result.id }}</td>
						<td>{{ result.name }}</td>
						<td>{{ result.department }}</td>
						<td>{{ result.professor }}</td>
						<td>{{ result.capacity }}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
</template>
<style>
.sugang {
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

.background {
	@import url('https://fonts.googleapis.com/css2?family=Gowun+Batang:wght@700&display=swap');
	font-family: "Gowun Batang", serif;
	font-weight: 700;
	font-style: normal;
	color: aliceblue;
	background-image: url("../img/space.png");
	width: 50%;
	margin: 0 auto;
}

table {
	margin: 0 auto;
}
</style>