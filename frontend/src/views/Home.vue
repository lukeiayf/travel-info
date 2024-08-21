<template>
    <div class="flex flex-col p-8 ">
        {{ travelInfo }}
    </div>

</template>
<script setup>
import { computed, onMounted, ref } from 'vue';
import store from '../store';
import { RouterLink } from 'vue-router';
import axiosClient from '../axiosClient';

const travelInfo = ref([]);

onMounted(async () => {
    const response = await axiosClient.get('Brazil');
    console.log(response.data);
    travelInfo.value = response.data;
});


</script>