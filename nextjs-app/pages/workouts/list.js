import Link from 'next/link'
import Head from 'next/head'

export default function scheduleList() {
  return  <>
    <Head>
        <title>Workouts List</title>
      </Head>
      <h1>Workouts List</h1>
      <h2>
        <Link href="/">
          <a>Back to home</a>
        </Link>
      </h2>
      </>

}
