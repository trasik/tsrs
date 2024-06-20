<script lang="ts">
	import Navigation from '$lib/components/Navigation.svelte';
	import { ModeWatcher } from 'mode-watcher';
	import '../app.css';
</script>

<ModeWatcher defaultMode={'dark'} />
<Navigation />
<slot></slot>
