<template>
    <div class="grid grid-cols-1 md:grid-cols-3 gap-5 p-8">
        <TravelInfoItem v-for="info of travelInfo" :key="info.destination" :travelInfo="info" />
    </div>
    <div v-if="!travelInfo.length" class="flex justify-center text-gray-600">
        No travel information could be found.
    </div>
</template>
<script setup>
import TravelInfoItem from './TravelInfoItem.vue';

const { travelInfo } = defineProps({
    travelInfo: {
        required: true,
        type: Array,
        default: () => []
    }
});

</script>