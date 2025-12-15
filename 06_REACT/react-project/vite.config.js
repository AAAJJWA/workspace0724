import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
      proxy: {
        "/api/members": {
          target: "http://localhost:8888",
          changeOrigin: true
        }
      }
    }
})
