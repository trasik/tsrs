<script lang="ts">
	import svgIcons from '$lib/svg-icons';
	import { toggleMode } from 'mode-watcher';
</script>

<nav class="w-screen flex p-4 bg-slate-300 dark:bg-slate-700 items-center">
	<h1 class="text-3xl font-bold justify-items-start">TSRS</h1>
	<ul class="flex gap-6 ml-8 justify-center w-screen text-xl font-medium md:gap-2">
		<li><a class="hover:bg-white/[0.5] rounded-xl p-2 transition" href="/">Home</a></li>
		<li>
			<a class="hover:bg-white/[0.5] rounded-xl p-2 transition" href="/supportrequests">Requests</a>
		</li>
	</ul>
	<button
		class="relative p-0.5 rounded-full backdrop-blur hover:bg-white/[0.5] transition mr-2 md:mr-0"
		on:click={toggleMode}
		><span class="rotate-0 scale-100 transition-all dark:-rotate-90 dark:opacity-0"
			>{@html svgIcons.sun}</span
		>
		<span
			class="absolute top-[1px] left-[2px] rotate-90 scale-0 transition-all dark:rotate-0 dark:scale-100 dark:fill-white"
			>{@html svgIcons.moon}</span
		></button
	>
</nav>
