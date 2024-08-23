<template>
    <div class="flex flex-col p-8 ">
    </div>

</template>
<script setup>
import { onMounted, ref } from 'vue';
import { axiosClient } from '../axiosClient';

const travelInfo = ref([]);

onMounted(async () => {
    const response = await axiosClient.get('Brazil');
    console.log(response.data);
    travelInfo.value = response.data.items;
});


</script>