import { useEffect, useState } from "react";

import { defaultConfig, INUFRConfig } from "./pages/INUFRConfig";

export function useNUFRConfig(configname: string) {

    const [loading, setLoading] = useState(true);
    const [config, setConfig] = useState<INUFRConfig>(defaultConfig);

    useEffect(() => {
        const fetchData = async () => {
            console.log("loading config for:" + configname)
            setLoading(true);
            import("../nufrConfig/" + configname + "Config").then(c => {
                setConfig(c.default);
                console.log('confg loaded!');
                setLoading(false);
            });
        };
        fetchData();
    }, [configname]);

    return { config, loading } as const;
}
