import Link from 'next/link'
import Head from 'next/head'
import Layout from '../../components/layout'


export default function exerciseList() {
  return  <>
    <Layout>
    <Head>
        <title>Exercise List</title>
      </Head>
      <h1>Exercise List</h1>
      <h2>
        <Link href="/">
          <a>Back to home</a>
        </Link>
      </h2>
      </Layout>
      </>

}
