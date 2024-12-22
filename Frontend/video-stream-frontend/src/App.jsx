import { useState } from 'react'
import './App.css'
import VideoUpload from './components/VideoUpload'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <div className='flex flex-col items-center justify-center py-10'>
      <h1 className=' text-3xl font-semibold font-mono text-gray-950 dark:text-gray-200'>Be Seen, Be Heard – Upload, Stream & Engage!</h1>
      <p className=' text-l font-medium text-gray-950 dark:text-gray-300 m-2'>Stream Your Passion, Build Your Audience, and Leave a Lasting Impact</p>
      <VideoUpload></VideoUpload>
     </div>
    </>
  )
}

export default App
